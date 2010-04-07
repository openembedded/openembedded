require midori.inc

DEPENDS += "python-native python-docutils-native"

# increment PR every time SRCREV is updated!
SRCREV = "400139644371c0b675723f9a986ddab4445a8794"
PR = "r2"
PV = "0.1.7+${PR}+gitr${SRCREV}"

SRC_URI = "git://git.xfce.org/apps/midori;protocol=git \
           file://waf \
           file://wscript-fix.patch;patch=1"

S = "${WORKDIR}/git"



do_configure() {
	cp -f ${WORKDIR}/waf ${S}/
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



