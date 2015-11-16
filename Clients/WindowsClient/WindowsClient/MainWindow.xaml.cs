using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using WindowsClient.Messages;
using WindowsClient.Pages;

namespace WindowsClient
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        String SERVER_ADDRESS = "192.168.1.70";
        int SERVER_PORT = 1337;

        Page loginPage;
        Page accountCreationPage;
        Page developerSettingsPage;

        public MainWindow()
        {
            loginPage = new Login();
            accountCreationPage = new AccountCreation();
            developerSettingsPage = new DeveloperSettings();
            InitializeComponent();
            frameMain.Navigate(loginPage);

            AuthenticationMessage authMessage = new AuthenticationMessage("Zarol", "12345", false);
            sendRequestToServer(authMessage);
        }

        public String sendRequestToServer(Message message)
        {
            try
            {
                TcpClient tcpClient = new TcpClient();
                tcpClient.Connect(SERVER_ADDRESS, SERVER_PORT);
                Console.WriteLine("Server Connected: " + tcpClient.Client.RemoteEndPoint.ToString());
                Console.WriteLine("Request: " + message.toJson().ToString(Formatting.None));

                Stream stream = tcpClient.GetStream();
                stream.Write(message.getMessageBytes(), 0, message.getMessageLength());

                byte[] messageByte = new byte[1024];
                stream.Read(messageByte, 0, 1024);

                String reply = System.Text.Encoding.Default.GetString(messageByte);

                Console.WriteLine("Reply: " + reply);
                Console.WriteLine("Server Disconnected: " + tcpClient.Client.RemoteEndPoint.ToString());
                return reply;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                return null;
            }
        }
    }
}
