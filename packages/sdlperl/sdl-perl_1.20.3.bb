DESCRIPTION = "Perl bindings for SDL"
HOMEPAGE = "http://bloodgate.com/perl"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "perl virtual/libsdl libsdl-image libsdl-gfx libsdl-ttf libsdl-mixer libsdl-net smpeg"

SRC_URI = "http://bloodgate.com/perl/sdl/pub/SDL_perl-${PV}.tar.gz \
    file://Makefile.patch;patch=1;pnum=0"
S = "${WORKDIR}/SDL_perl-${PV}"

do_configure () {
        if [ -x ${S}/configure ] ; then
                cfgcmd="${S}/configure \
                    -GL -GLU"
                oenote "Running $cfgcmd..."
                $cfgcmd || oefatal "oe_runconf failed"
		if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
			. ${STAGING_DIR}/${TARGET_SYS}/perl/config.sh
			sed -e "s:\(SITELIBEXP = \).*:\1${sitelibexp}:; s:\(SITEARCHEXP = \).*:\1${sitearchexp}:; s:\(INSTALLVENDORLIB = \).*:\1${D}${libdir}/perl5:; s:\(INSTALLVENDORARCH = \).*:\1${D}${libdir}/perl5:" < Makefile > Makefile.new
			mv Makefile.new Makefile
		fi
        else
                oefatal "no configure script found"
        fi
}

do_stage () {
    install -d ${STAGING_LIBDIR}/perl5/vendor_perl
    install -m 0644 ${S}/lib/SDL.pm ${STAGING_LIBDIR}/perl5/vendor_perl
}

do_compile () {
        oe_runmake PASTHRU_INC="${CFLAGS}"
}

do_install () {
	oe_runmake install_vendor
}

FILES_${PN} += '${libdir}/perl5'
