require midori.inc

PR = "r2"

DEPENDS += "python-native python-docutils-native"

SRC_URI = "http://archive.xfce.org/src/apps/midori/0.1/midori-${PV}.tar.bz2 \
           file://waf \
          "

SRC_URI_append_shr = "file://ua-iphone-0.1.10.patch;patch=1 \
                      file://config"

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


SRC_URI[md5sum] = "97b6a3a3ccb8458c68c335b2ee8e9197"
SRC_URI[sha256sum] = "1f6a3af09ea9b9669c4b1a7ca2a8cbee5114dac2612e6f5ced1ea7ea4967fbfc"
