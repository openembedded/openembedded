# This recipe is a regeneration of the original opkg-nogpg-nocurl_svn.bb
# recipe, intended for temporary use by the SlugOS distro.

# DO NOT USE this recipe for anything other than SlugOS and svn version 160
# of the opkg sources.  Also note that this recipe will be removed without
# notice when the unfortunate commits to the original opkg-nogpg-nocurl_svn.bb
# recipe are repaired, the small-memory patches updated to a newer opkg svn
# version, and appropriate testing confirms that the resulting binary actually
# works correctly on a 32MB system.

# DO NOT CHANGE THIS RECIPE!

DESCRIPTION = "Opkg Package Manager"
DESCRIPTION_libopkg = "Opkg Package Manager Library"
SECTION = "base"
LICENSE = "GPLv2"
SRCREV = "160"
PV = "0.1.6+svnr${SRCPV}"
PR = "r22"

PROVIDES += "opkg"
S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

SRC_URI += " \
	    svn://opkg.googlecode.com/svn;module=trunk;proto=http \
	    file://opkg_unarchive.patch;maxrev=201 \
	    file://opkg-intercept-cleanup.patch;maxrev=241 \
	    file://isatty.patch \
	    file://opkg_wget.patch;maxrev=180 \
	    file://reduce-nogpg-noise.patch;maxrev=180 \
	    file://opkg_wget_nogpg_01_use_vfork_gunzip.patch \
	    file://opkg_wget_nogpg_02_use_vfork_system.patch \
	    file://opkg_wget_nogpg_03_fix_tmpdirs.patch \
	    file://opkg_wget_nogpg_04_default_tmpdir.patch \
	    file://configure \
	   "

EXTRA_OECONF += "--disable-gpg --enable-static --disable-shared"

do_install_prepend() {
  install -d ${D}${sysconfdir}/rcS.d
  install -m 0755 ${WORKDIR}/configure ${D}${sysconfdir}/rcS.d/S98configure
}

# Not sure this is needed; needs to be investigated and removed if not

# The nogpg version isn't getting much love and has an unused variable which trips up -Werror
do_configure_prepend() {
	sed -i -e s:-Werror::g ${S}/libopkg/Makefile.am
}

PACKAGES =+ "libopkg-dev"

FILES_libopkg-dev = "${libdir}/*.a ${libdir}/*.la ${libdir}/*.so"
# not happens automatically for opkg-nogpg:
FILES_${PN} += "${datadir}/opkg/intercept"

pkg_postinst_${PN} () {
  update-alternatives --install ${bindir}/opkg opkg ${bindir}/opkg-cl 100
}

pkg_postrm_${PN} () {
  update-alternatives --remove opkg ${bindir}/opkg-cl
}

DEFAULT_PREFERENCE = "-1"
