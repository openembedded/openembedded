require midori.inc

DEPENDS += "python-native python-docutils-native"

SRC_URI = "http://archive.xfce.org/src/apps/midori/0.2/midori-${PV}.tar.bz2 \
           file://waf"

SRC_URI_append_shr = " file://config \
                       file://retain-navigationbar-in-fullwindow.patch;patch=1 \
                     "

PR = "r2"

do_configure() {
	cp -f ${WORKDIR}/waf ${S}/
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
 
	sed -i /LINK_CC/d ./_build_/c4che/default.cache.py 
	echo "LINK_CC = '${CXX}'" >>  ./_build_/c4che/default.cache.py
}

do_install_append_shr() {
	install -d ${D}${sysconfdir}/xdg/midori
	install -m 0644 ${WORKDIR}/config ${D}${sysconfdir}/xdg/midori
}

