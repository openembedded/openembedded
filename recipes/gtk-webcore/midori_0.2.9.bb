require midori.inc

DEPENDS += "vala-native python-native python-docutils-native"

SRC_URI = "http://archive.xfce.org/src/apps/midori/0.2/midori-${PV}.tar.bz2;name=midori \
"

SRC_URI[midori.md5sum] = "a5821d8e31fa944374ed51c09ca4e740"
SRC_URI[midori.sha256sum] = "803bf534ab73cf7a50ddd38bbd68976258c36f335a3f1dc1880f53915c7fdf78"

SRC_URI_append_shr = " file://config \
"

do_configure() {
	sed -i -e 's:, shell=False::g' wscript 
	./configure \
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

do_install_append_shr() {
	install -d ${D}${sysconfdir}/xdg/midori
	install -m 0644 ${WORKDIR}/config ${D}${sysconfdir}/xdg/midori
}

