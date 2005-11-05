BROKEN = "1"
# is unfetchable now - upstream updated to 20050728

DEPENDS += "lua-native lua x11 xext"
DESCRIPTION = "Ion is a tiling tabbed window manager designed with keyboard \
users in mind."
HOMEPAGE = "http://modeemi.fi/~tuomov/ion/"
LICENSE = "LGPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
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
		 --with-lua-prefix=${STAGING_BINDIR}/.. \
		 --x-libraries=${STAGING_LIBDIR} \
		 --x-includes=${STAGING_INCDIR}"

inherit autotools
