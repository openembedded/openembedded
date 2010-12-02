require bug-app.inc

DESCRIPTION = "This is a small app showing how to set the DAC channels and read the ADC on the vonHippel module.\
Some hints:\
Before using the DAC the DAC needs to be powered up by sending the suitable command to the DAC chip (MAX4820M ).\
e.g. writeDAC(0x0CF0) will wake up both channels\
The app shows how to operate the ADC in single ended mode. The voltage input range is 0 .. 2.5V.\
The writeDAC() and writeADC() methods send data directly to the chips. Be aware of the byte order in Java. The data is sent lobyte first. i.e. writeDAC(0x1234) will send 0x34 first then 0x12.\
Information about the ADC (LTC2487) and DAC (MAX5820M) can be found in the datasheets.\
"
HOMEPAGE = "http://buglabs.net/applications/vonHippelAnalogDemo"

DEPENDS += "com.buglabs.osgi com.buglabs.bug.module.vonhippel com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/1057"

APIVERSION = "1.4.3"
