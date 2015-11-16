using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsClient.Messages
{
    public interface Message
    {
        JObject toJson();
        byte[] getMessageBytes();
        int getMessageLength();
    }
}
