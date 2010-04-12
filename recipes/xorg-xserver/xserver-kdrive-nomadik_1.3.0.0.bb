require xserver-kdrive-common.inc

FILESPATH += ":${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xserver-kdrive-1.3.0.0:${@os.path.dirname(bb.data.getVar('FILE',d,1))}/xserver-kdrive"

DEPENDS += "sgalib"
COMPATIBLE_MACHINE = "nhk15"

PACKAGES =+ "xserver-kdrive-nomadikfb"
DESCRIPTION_xserver-kdrive-nomadikfb = "Nomadik X server"
PACKAGE_ARCH = "${MACHINE}"

PR = "r38"

FILES_xserver-kdrive-nomadikfb = "${bindir}/Xnomadik"
FILES_xserver-kdrive-nomadikfb-dbg = "${bindir}/.debug/Xnomadik"

RDEPENDS_xserver-kdrive-nomadikfb = "sga-init"
RRECOMMENDS_xserver-kdrive-nomadikfb = "kernel-module-nmdkmod-sva"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
        file://nomadik_xserver_1300.patch;patch=1 \
        file://nomadik_xserver_sva_service_cleanup.patch;patch=1 \
        file://autotools.patch;patch=1 \
        file://fix-picturestr-include-order.patch;patch=1" 

S = "${WORKDIR}/xorg-server-${PV}"

EXTRA_OECONF = "--enable-composite --enable-kdrive \
		--disable-dga --disable-dri --disable-xinerama \
		--disable-xf86misc --disable-xf86vidmode \
		--disable-xorg --disable-xorgcfg \
		--disable-dmx \ 
		--disable-xkb --disable-xnest --disable-xvfb \
		--disable-xevie --disable-xprint --disable-xtrap \
		--with-default-font-path=built-ins \
                --enable-tslib --enable-xcalibrate \
                --enable-nomadik \
# --enable-glx \
		--enable-xegl \
                --with-kernel-headers-path=${STAGING_KERNEL_DIR} \
		ac_cv_file__usr_share_X11_sgml_defs_ent=no"

do_install() {
        autotools_do_install
}

SRC_URI[md5sum] = "a51a7d482e3c689394755bb17bda8526"
SRC_URI[sha256sum] = "93c656f142f37607c15372dd24c5de9eab82cd79c5d60449174a928d345c2975"
