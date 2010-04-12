require u-boot.inc

PR = "r3"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-1.2.0.tar.bz2 \
	"
SRC_URI_append_turbostation = "file://qnap.diff;patch=1"

SRC_URI_append_lsppchg = "file://u-boot-kurobox.patch;patch=1 \
			  file://u-boot-kurobox-fdt.patch;patch=1 \
			  file://defconfig_lsppchg"

SRC_URI_append_lsppchd = "file://u-boot-kurobox.patch;patch=1 \ 
                          file://u-boot-kurobox-fdt.patch;patch=1 \ 
                          file://defconfig_lsppchg"

SRC_URI_append_dm355-leopard = " file://dm355-leopard.diff;patch=1"

do_compile_prepend_lsppchg () {
        cp ${WORKDIR}/defconfig_lsppchg ${S}/include/configs/linkstation.h
}

do_compile_prepend_lsppchd () {
        cp ${WORKDIR}/defconfig_lsppchd ${S}/include/configs/linkstation.h
}

SRC_URI_append_mpc8315e-rdb = " \
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-pre.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-soc.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-PHY.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-platform.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-nand-controller.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-nand-boot.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-serdes.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-pcie.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-fsl-1.3.0-MPC83xx-CW.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-silicon-1.1-1.2.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-extra-config-for-333-266MHz.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-resume-deep-sleep.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-improve-ddr-performance.patch;patch=1 \ 
http://www.bitshrine.org/gpp/u-boot-1.2.0-mpc8315erdb-fix-PCI-IO-base.patch;patch=1 \ 
"


SRC_URI[md5sum] = "17aeee76ca4c07887bbfea8a52d40884"
SRC_URI[sha256sum] = "62192ddf019c5d24f6538b33c9e69b6e5792bf5b0f464c0149061e2f0871108b"
