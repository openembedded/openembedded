DESCRIPTION = " Client libraries for GamingZone"
LICENSE = "LGPLv2"
DEPENDS = "libggz" 

SRC_URI = "http://ftp.belnet.be/packages/ggzgamingzone/ggz/${PV}/${PN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-libggz-includes=${STAGING_INCDIR} \
                --with-libggz-libraries=${STAGING_LIBDIR} \
               "

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do 
		sed -i -e s:'-I /usr/include -I /usr/local/include'::g $i
	done
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}


