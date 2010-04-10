DESCRIPTION = "setserial is a program designed to set and/or \
report the configuration information associated with a serial port"
HOMEPAGE = "http://setserial.sourceforge.net"
AUTHOR = "Theodore Ts'o >tytso@mit.edu>"
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r3"

inherit autotools

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/setserial/${PN}-${PV}.tar.gz \
  file://addflags.patch;patch=1 \
"

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${mandir}/man8
        
        install -m 0755 ${S}/setserial   ${D}${bindir}
        install -m 0644 ${S}/setserial.8 ${D}${mandir}/man8
}

SRC_URI[md5sum] = "c4867d72c41564318e0107745eb7a0f2"
SRC_URI[sha256sum] = "7e4487d320ac31558563424189435d396ddf77953bb23111a17a3d1487b5794a"
