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
        public MainWindow()
        {
            InitializeComponent();
            sendRequestToServer();
        }

        public void sendRequestToServer()
        {
            try
            {
                TcpClient tcpClient = new TcpClient();
                Console.WriteLine("Connecting...");

                tcpClient.Connect("192.168.1.70", 1337);
                Console.WriteLine("Connected");


                AuthenticationMessage message = new AuthenticationMessage("Zarol", "12345", false);

                Stream stream = tcpClient.GetStream();
                stream.Write(message.getMessageBytes(), 0, message.getMessageLength());

                byte[] messageByte = new byte[1024];
                stream.Read(messageByte, 0, 1024);

                String reply = System.Text.Encoding.Default.GetString(messageByte);

                Console.WriteLine(reply);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }
    }
}
