require midori.inc

DEPENDS += "vala-native python-native python-docutils-native"

# increment PR every time SRCREV is updated!
SRCREV = "ad2f0066ce969152080cd841ce4cdd0920565409"
PR = "r0"
PV = "0.2.9+${PR}+gitr${SRCPV}"

SRC_URI = "git://git.xfce.org/apps/midori;protocol=git"

S = "${WORKDIR}/git"

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

