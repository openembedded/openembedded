DESCRIPTION = "UrJTAG is a universal JTAG library, servers and tools"
HOMEPAGE = "http://urjtag.org/"
LICENSE = "GPLv2"
DEPENDS = "libftdi libusb gettext readline"

SRCREV = "fc8686b8dd545f54d25e77f65e43f4d774bc46"

PV = "0.10"
PR = "r0"
PR_append = "+gitr${SRCPV}"

S = "${WORKDIR}/git/urjtag"

SRC_URI = "git://urjtag.git.sourceforge.net/gitroot/urjtag/urjtag;protocol=git;branch=master \
	"
inherit autotools

# no idea why -s would make a difference but without it configure fails.
# guess the symlink is created before the actual content is there
EXTRA_AUTORECONF = "-s"

do_install () {
        oe_runmake DESTDIR=${D} MKINSTALLDIRS="${S}/tools/mkinstalldirs" install
}
