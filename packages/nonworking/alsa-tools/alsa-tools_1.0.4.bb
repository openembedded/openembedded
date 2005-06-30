DESCRIPTION="Alsa Tools"
MAINTAINER="Lorn Potter <lpotter@trolltech.com>"
LICENSE="GPL"
DEPENDS=""

SRC_URI="ftp://ftp.alsa-project.org/pub/tools/alsa-tools-${PV}.tar.bz2"

inherit autotools

dirs = "ac3dec \
        as10k1 \
        envy24control \
        hdsploader \
        hdspmixer \
        mixartloader \
        rmedigicontrol \
        sb16_csp \
        seq \
        sscape_ctl \
        us428control \
        usx2yloader \
        vxloader"

do_configure () {
	for d in ${dirs}; do
		(
			S="$S/$d"
			cd ${S}
			oe_runconf
		)
	done
}

do_compile () {
	for d in ${dirs}; do
		(
			cd ${S}/$d
			oe_runmake
		)
	done
}

do_install () {
	for d in ${dirs}; do
		(
			cd ${S}/$d
			oe_runmake 'DESTDIR=${D}' install
		)
	done
}
