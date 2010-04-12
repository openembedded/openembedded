DESCRIPTION = "A small network printer daemon for embedded situations that passes the job directly to the printer."
SECTION = "console/utils"
HOMEPAGE = "http://p910nd.sourceforge.net/"
LICENSE = "GPLv2"
SECTION = "console/utils"
PR = "r0"
RRECOMMENDS = "avahi"

inherit update-rc.d

INITSCRIPT_NAME = "p910nd"
INITSCRIPT_PARAMS = "defaults 60 "

SRC_URI = "http://internap.dl.sourceforge.net/sourceforge/p910nd/p910nd-0.92.tar.bz2 \
           file://p910nd.init \
           file://avahi"

do_compile () {
	${CC} -o p910nd p910nd.c 
}

# The avahi stuff makes it work with bonjour printing
do_install () {
	install -D -m 0755 ${S}/p910nd ${D}${sbindir}/p910nd
	install -D -m 0644 ${S}/p910nd.conf ${D}${sysconfdir}/p910nd.conf
	install -D -m 0755 ${WORKDIR}/p910nd.init ${D}${sysconfdir}/init.d/p910nd
	install -D -m 0755 ${WORKDIR}/avahi ${D}${sysconfdir}/avahi/services/p910nd.service
}

pkg_postinst_append() {
#!/bin/sh
           
if [ "x$D" != "x" ] ; then
        exit 1
fi

# If avahi is already running reload it to pickup the p910nd config
PAV=`pidof avahi-daemon`
if [ "x$PAV" != "x" ] ; then
        /etc/init.d/avahi-daemon reload
fi
}

SRC_URI[md5sum] = "94a43d28794f2445cd5f9c8b970898c4"
SRC_URI[sha256sum] = "a2295e525febfc3a1a93ad21c0843021e2b22e6720f148bf1c4822a83aea2b8c"
