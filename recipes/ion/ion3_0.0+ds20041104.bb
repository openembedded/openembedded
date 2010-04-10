BROKEN = "1"
# is unfetchable now - upstream updated to 20050728

DEPENDS += "lua-native lua virtual/libx11 libxext"
DESCRIPTION = "Ion is a tiling tabbed window manager designed with keyboard \
users in mind."
HOMEPAGE = "http://modeemi.fi/~tuomov/ion/"
LICENSE = "LGPL"
PROVIDES += "ion"
SECTION = "x11/wm"
SNAPDATE = "${@(bb.data.getVar('PV', d, 1) or '')[-8:]}"

# Currently excluded from world builds due to requiring a full libX11
# rather than diet.
BROKEN = "1"

SRC_URI = "http://modeemi.fi/~tuomov/ion/dl/ion-3ds-${SNAPDATE}.tar.gz \
	   file://201_fix-paths.diff;patch=1 \
	   file://202_fix-menus.diff;patch=1 \
	   file://203_fix-kludges.diff;patch=1 \
	   file://204_fix-bindings.diff;patch=1 \
	   file://205_ion-lock.diff;patch=1 \
	   file://206_use-xterm.diff;patch=1 \
	   file://luaconfig.patch;patch=1 \
	   file://cross.patch;patch=1"
S = "${WORKDIR}/ion-3ds-${SNAPDATE}"

EXTRA_OECONF += "--disable-xinerama --disable-xfree86-textprop-bug-workaround \
		 --disable-Xutf8 --disable-sun-fix-remap --enable-shared \
		 --with-lua-prefix=${STAGING_BINDIR_NATIVE}/.. \
		 --x-libraries=${STAGING_LIBDIR} \
		 --x-includes=${STAGING_INCDIR}"

inherit autotools

SRC_URI[md5sum] = "e187a0ca83642afddf3b21898b683ced"
SRC_URI[sha256sum] = "b47388c35922bc0f3419a2b059c77b80fee1c5b6d0ffcde7442c854fac6e90d6"
