require midori.inc

DEPENDS += "python-native librsvg"

SRC_URI = "\
	http://goodies.xfce.org/releases/midori/midori-${PV}.tar.bz2\
	file://ua-iphone.patch;patch=1\
"

PR = "r0"

CC += "-lstdc++"

do_configure() {
	${S}/configure \
            --prefix=${prefix} \
            --bindir=${bindir} \
            --sbindir=${sbindir} \
            --libexecdir=${libexecdir} \
            --datadir=${datadir} \
            --sysconfdir=${sysconfdir} \
            --sharedstatedir=${sharedstatedir} \
            --localstatedir=${localstatedir} \
            --libdir=${libdir} \
            --includedir=${includedir} \
            --infodir=${infodir} \
            --mandir=${mandir} \
            ${EXTRA_OECONF}
}
