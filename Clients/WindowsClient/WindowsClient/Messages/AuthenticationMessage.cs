using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsClient.Messages
{
    class AuthenticationMessage : Message
    {
        const String MESSAGE_TYPE = "Authentication";
        const String USERNAME_KEY = "Username";
        const String PASSWORD_KEY = "Password";
        const String AUTHENTICATED_KEY = "Authenticated";

        public String Username
        {
            get { return username; }
            set { username = value; }
        }
        public String Password
        {
            get { return password; }
            set { password = value; }
        }
        public Boolean Authenticated
        {
            get { return authenticated; }
            set { authenticated = value; }
        }

        String username;
        String password;
        Boolean authenticated;

        public AuthenticationMessage(String username, String password, Boolean authenticated)
        {
            this.username = username;
            this.password = password;
            this.authenticated = authenticated;
        }

        public AuthenticationMessage(JObject jobject)
        {
            JObject contents = JObject.Parse(jobject.GetValue(MESSAGE_TYPE).ToString());
            this.username = contents.GetValue(USERNAME_KEY).ToString();
            this.password = contents.GetValue(PASSWORD_KEY).ToString();
            this.authenticated = Convert.ToBoolean(contents.GetValue(AUTHENTICATED_KEY).ToString());
        }

        public JObject toJson()
        {
            JObject messageBuilder = new JObject();
            JObject thisBuilder = new JObject();
            thisBuilder.Add(USERNAME_KEY, this.username);
            thisBuilder.Add(PASSWORD_KEY, this.password);
            thisBuilder.Add(AUTHENTICATED_KEY, this.authenticated);

            messageBuilder.Add( MESSAGE_TYPE, thisBuilder);
            return messageBuilder;
        }

        public byte[] getMessageBytes()
        {
            ASCIIEncoding encoder = new ASCIIEncoding();
            return encoder.GetBytes( toJson().ToString(Formatting.None) );
        }

        public int getMessageLength()
        {
            return getMessageBytes().Length;
        }
    }
}
