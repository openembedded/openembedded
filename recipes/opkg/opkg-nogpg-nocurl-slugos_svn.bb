# This recipe is a regeneration of the original opkg-nogpg-nocurl_svn.bb
# recipe, intended for temporary use by the SlugOS distro.

# DO NOT USE this recipe for anything other than SlugOS and svn version 160
# of the opkg sources.  Also note that This recipe will be removed without
# notice when the unfortunate commits to the original opkg-nogpg-nocurl_svn.bb
# recipe are repaired, the small-memory patches updated to a newer opkg svn
# version, and appropriate testing confirms that the resulting binary actually
# works correctly on a 32MB system.

# DO NOT CHANGE THIS RECIPE!

require opkg.inc

DEPENDS = ""
PROVIDES += "opkg"

SRC_URI += " \
	    file://isatty.patch;patch=1 \
	    file://opkg_wget.patch;patch=1;maxrev=180 \
	    file://reduce-nogpg-noise.patch;patch=1;maxrev=180 \
	    file://opkg_wget_nogpg_01_use_vfork_gunzip.patch;patch=1 \
	    file://opkg_wget_nogpg_02_use_vfork_system.patch;patch=1 \
	    file://opkg_wget_nogpg_03_fix_tmpdirs.patch;patch=1 \
	    file://opkg_wget_nogpg_04_default_tmpdir.patch;patch=1 \
	   "
PR = "${INC_PR}"

EXTRA_OECONF += "--disable-gpg --enable-static --disable-shared"

# Not sure this is needed; needs to be investigated and removed if not
do_stage() {
	autotools_stage_all
}

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}

PACKAGES =+ "libopkg-dev"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
# not happens automatically for opkg-nogpg:
FILES_${PN} += "${datadir}/opkg/intercept"

# Define a variable to allow distros to run configure earlier.
# (for example, to enable loading of ethernet kernel modules before networking starts)
OPKG_INIT_POSITION = "98"
OPKG_INIT_POSITION_slugos = "41"

pkg_postinst_${PN} () {
  update-alternatives --install ${bindir}/opkg opkg ${bindir}/opkg-cl 100
}

pkg_postrm_${PN} () {
  update-alternatives --remove opkg ${bindir}/opkg-cl
}

DEFAULT_PREFERENCE = "-1"
