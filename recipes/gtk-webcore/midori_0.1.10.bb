require midori.inc

DEPENDS += "python-native librsvg python-docutils-native"

SRC_URI = "\
	http://archive.xfce.org/src/apps/midori/0.1/midori-${PV}.tar.bz2\
	file://ua-iphone-0.1.10.patch;patch=1\
	file://config\
"

PR = "r2"

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

do_install_append() {
	install -d ${D}${sysconfdir}/xdg/midori
	install -m 0644 ${WORKDIR}/config ${D}${sysconfdir}/xdg/midori
}
