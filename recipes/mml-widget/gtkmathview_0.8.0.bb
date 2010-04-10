LICENSE = "GPL"
HOMEPAGE = "http://helm.cs.unibo.it/mml-widget/"
DEPENDS = "t1lib gtk+ popt libxslt libxml2"

PR = "r1"

SRC_URI = "http://helm.cs.unibo.it/mml-widget/sources/${P}.tar.gz \
           file://mathview-gcc43x.diff;patch=1 \
	  "

inherit autotools 
AUTOTOOLS_STAGE_PKGCONFIG = 1

EXTRA_OECONF = "--disable-binreloc"

do_configure_prepend() {
	sed -i -e s:AM_BINRELOC::g ${S}/configure.ac
}

do_stage() {
	autotools_stage_all
	for i in ${PKG_CONFIG_DIR}/*math*.pc ; do
		sed -i -e s:${STAGING_INCDIR}:'${libdir}':g $i
	done	
}


SRC_URI[md5sum] = "b53564e553728d4b69f7d366dfeb5299"
SRC_URI[sha256sum] = "1dc30175da6a3c560a7d62d1abe1c2f9829d988e6f1a7c5e766544575c558c43"
