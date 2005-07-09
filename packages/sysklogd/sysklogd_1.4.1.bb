LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The sysklogd package implements \
two system log daemons."

SRC_URI = "http://www.ibiblio.org/pub/Linux/system/daemons/sysklogd-${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1"

CFLAGS_append = " -DSYSV"

do_install () {
	install -d ${D}${mandir}/man8 \
		   ${D}${mandir}/man5 \
		   ${D}${bindir}
	oe_runmake 'BINDIR=${D}${bindir}' \
		   'MANDIR=${D}${mandir}' install
}
