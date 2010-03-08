require midori.inc

DEPENDS += "python-native python-docutils-native"

SRC_URI = "http://archive.xfce.org/src/apps/midori/0.2/midori-${PV}.tar.bz2;name=midori \
           file://waf"
SRC_URI[midori.md5sum] = "ccd2ae162993c2c92c9e0eac7778c62d"
SRC_URI[midori.sha256sum] = "02a2b13e2ca51badae828b0a331af92f09ae3d6a9ab0a56e647544db64f7790f"

SRC_URI_append_shr = " file://config \
                     "

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

