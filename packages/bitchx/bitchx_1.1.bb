DESCRIPTION = "BitchX is a IRC client"
SECTION = "console/network"

LICENSE = "BSD"

SRC_URI = "http://www.bitchx.org/files/source/ircii-pana-${PV}-final.tar.gz \
	   file://gcc34.patch;patch=1"
S = "${WORKDIR}/BitchX"

inherit autotools

do_configure() {
        gnu-configize
        oe_runconf
}

do_install() {
	oe_runmake install \
                    prefix=${D}${prefix} \
                    exec_prefix=${D}${exec_prefix} \
                    bindir=${D}${bindir} \
                    sbindir=${D}${sbindir} \
                    libexecdir=${D}${libexecdir} \
                    datadir=${D}${datadir} \
                    sysconfdir=${D}${sysconfdir} \
                    sharedstatedir=${D}${sharedstatedir} \
                    localstatedir=${D}${localstatedir} \
                    libdir=${D}${libdir} \
                    includedir=${D}${includedir} \
                    oldincludedir=${D}${oldincludedir} \
                    infodir=${D}${infodir} \
                    mandir=${D}${mandir}
	ln -sf ./BitchX-1.1-final ${D}${bindir}/BitchX
}

