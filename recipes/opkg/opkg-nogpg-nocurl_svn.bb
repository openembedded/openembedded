require opkg_svn.bb

DEPENDS = ""
PROVIDES += "opkg"

SRC_URI += " \
	    file://opkg_wget.patch;patch=1;maxrev=180 \
	    file://reduce-nogpg-noise.patch;patch=1;maxrev=180 \
	    file://opkg_wget_nogpg_01_use_vfork_gunzip.patch;patch=1 \
	    file://opkg_wget_nogpg_02_use_vfork_system.patch;patch=1 \
	    file://opkg_wget_nogpg_03_fix_tmpdirs.patch;patch=1 \
	    file://opkg_wget_nogpg_04_default_tmpdir.patch;patch=1 \
	   "
PR = "r8"

SRCREV = "${SRCREV_pn-opkg}"

EXTRA_OECONF += "--disable-gpg --enable-static --disable-shared"

# NOTE: Use this one after svn rev 180 (should be a different recipe)
#EXTRA_OECONF += "--disable-gpg --disable-curl --enable-static --disable-shared"

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}

DEFAULT_PREFERENCE = "-1"
