DESCRIPTION = "AVRDUDE is software for programming Atmel AVR Microcontrollers."
HOMEPAGE = "http://www.nongnu.org/avrdude/"
SECTION = "console"
LICENSE = "GPLv2"

DEPENDS = "virtual/libusb0 ncurses"

SRC_URI = "http://savannah.nongnu.org/download/avrdude/avrdude-${PV}.tar.gz"

inherit autotools

