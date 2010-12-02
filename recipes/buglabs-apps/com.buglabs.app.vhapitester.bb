require bug-app.inc

DESCRIPTION = "internal use only... tests methods from IVonHippelModule control, implemented in VonHippelModlet.  Prerequisites:\
testing should be done from a linux computer in order to test the serial API.\
when testing Serial In, you will need my special serial cable and do something like:\
@$ echo 'a small brown fox... XXX' > /dev/ttyUSB1@\
the XXX signals end of output so it is required.  You should see that output on the bug in concierge.log\
then to test Serial Output:\
@$ od /dev/ttyUSB1 @\
or\
@$ cat /dev/ttyUSB1@\
and you should see something like:\
@Your face Your face Your face etc.@\
The output looks like that below (from concierge.log):\
@---------------------------\
|Testing GPIO calls |\
---------------------------\
GPIO Pin 0 made to output, set to 1 Status: 1111 Expected 1111\
GPIO Pin 1 made to output, set to 1 Status: 1111 Expected 1111\
GPIO Pin 2 made to output, set to 1 Status: 1111 Expected 1111\
GPIO Pin 3 made to output, set to 1 Status: 1111 Expected 1111\
GPIO Pin 0 cleared, set to 0        Status: 1110 Expected 1110\
GPIO Pin 1 cleared, set to 0        Status: 1100 Expected 1100\
GPIO Pin 2 cleared, set to 0        Status: 1000 Expected 1000\
GPIO Pin 3 cleared, set to 0        Status: 0 Expected 0\
GPIO Pin 0 made to input, set to 1 Status: 1 Expected 1\
GPIO Pin 1 made to input, set to 1 Status: 11 Expected 11\
GPIO Pin 2 made to input, set to 1 Status: 111 Expected 111\
GPIO Pin 3 made to input, set to 1 Status: 1111 Expected 1111\
--------------------\
|Testing IOX calls  |\
--------------------\
IOX Pin 0 made to output, set to 1 Status: 1000001 Expected 1000001\
IOX Pin 1 made to output, set to 1 Status: 1000011 Expected 1000011\
IOX Pin 2 made to output, set to 1 Status: 1000111 Expected 1000111\
IOX Pin 3 made to output, set to 1 Status: 1001111 Expected 1001111\
IOX Pin 4 made to output, set to 1 Status: 1011111 Expected 1011111\
IOX Pin 5 made to output, set to 1 Status: 1111111 Expected 1111111\
IOX Pin 0 cleared, set to 0        Status: 1111110 Expected 1111110\
IOX Pin 1 cleared, set to 0        Status: 1111100 Expected 1111100\
IOX Pin 2 cleared, set to 0        Status: 1111000 Expected 1111000\
IOX Pin 3 cleared, set to 0        Status: 1110000 Expected 1110000\
IOX Pin 4 cleared, set to 0        Status: 1100000 Expected 1100000\
IOX Pin 5 cleared, set to 0        Status: 1000000 Expected 1000000\
IOX Pin 0 made to input, set to 1  Status: 1000000 Expected 1000000\
IOX Pin 1 made to input, set to 1  Status: 1000000 Expected 1000000\
IOX Pin 2 made to input, set to 1  Status: 1000000 Expected 1000000\
IOX Pin 3 made to input, set to 1  Status: 1000000 Expected 1000000\
IOX Pin 4 made to input, set to 1  Status: 1000000 Expected 1000000\
IOX Pin 5 made to input, set to 1  Status: 1000000 Expected 1000000\
--------------------\
|Testing Serial In  |\
--------------------\
icky icky poo po\
---------------------------\
|Testing Serial Out  |\
---------------------------\
------------------------------------------------------\
|Testing unimplemented methods (1.4)  |\
------------------------------------------------------@\
"
HOMEPAGE = "http://buglabs.net/applications/VHAPITester"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.vonhippel "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/448"

APIVERSION = ""

BROKEN = "1"
