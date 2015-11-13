using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json;

namespace WindowsClient.Messages
{
    class AuthenticationMessage
    {
        static String MESSAGE_TYPE = "Authentication";

        public String getUsername() { return username; }

        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }

        public void setPassword(String password) { this.password = password; }

        public Boolean isAuthenticated() { return authenticated; }

        public void setAuthenticated(Boolean authenticated) { this.authenticated = authenticated; }

        String username;
        String password;
        Boolean authenticated;

        public AuthenticationMessage(String username, String password, Boolean authenticated)
        {
            this.username = username;
            this.password = password;
            this.authenticated = authenticated;
        }

        public JObject toJson()
        {
            JObject messageBuilder = new JObject();
            JObject thisBuilder = new JObject();
            thisBuilder.Add("Username", this.username);
            thisBuilder.Add("Password", this.password);
            thisBuilder.Add("Authenticated", this.authenticated);

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
