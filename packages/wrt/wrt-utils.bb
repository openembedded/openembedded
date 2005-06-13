DESCRIPTION = "wrt tools"
SECTION = "base"
LICENSE = "broadcom"
SRC_URI = "cvs://anonymous@openwrt.org/openwrt;module=openwrt/package/openwrt;tag=TESTED \
	http://openwrt.inf.fh-brs.de/mirror/linksys-wlconf.tar.gz \
	file://nvram-makefile.diff;patch=1;pnum=0 \
	file://libshared-makefile.diff;patch=1;pnum=0"

S = "${WORKDIR}/openwrt"

inherit module-base

TARGET_CFLAGS =+ "-I${STAGING_KERNEL_DIR}/include"

do_compile() {
	make -C libshared TARGET_CC="${CC}"
	make -C libnvram TARGET_CC="${CC}"
	
	${CC} ${CFLAGS} -Iinclude -o wlc wlc.c -L./libshared -lshared
	${CC} ${CFLAGS} -o jffs2root jffs2root.c
	${CC} ${CFLAGS} -o mtd mtd.c
	
	make -C ../linksys-wlconf TOP=${S} SRCBASE=${S} LDFLAGS="-L${S}/libnvram -lnvram -L${S}/libshared -lshared"

	${KERNEL_CC} -D__KERNEL__ -fno-strict-aliasing -fno-common -fomit-frame-pointer -G 0 \
	-mno-abicalls -fno-pic -finline-limit=100000 -mabi=32 -march=mips32 -Wa,-32 \
	-Wa,-march=mips32 -Wa,-mips32 -Wa,--trap -DMODULE -mlong-calls -fno-common \
	-funsigned-char -nostdinc -iwithprefix include -I. -I${STAGING_KERNEL_DIR}/include \
	-I${STAGING_KERNEL_DIR}/include/asm/gcc -I./include -c -o wlcompat.o wlcompat.c
}

do_install() {
	install -d ${D}/usr/sbin/ ${D}/sbin/ ${D}/${libdir} ${D}/lib/modules/${KERNEL_VERSION}
	install -m 644 libshared/libshared.so ${D}/${libdir}
	install -m 755 libnvram/nvram ${D}/usr/sbin/
	install -m 644 libnvram/libnvram.so ${D}/${libdir}
	
	install -m 755 wlc ${D}/usr/sbin/
	install -m 755 jffs2root ${D}/sbin/
	install -m 755 mtd ${D}/sbin/
	
	install -m 755 ../linksys-wlconf/wlconf ${D}/usr/sbin/
	install -m 644 wlcompat.o ${D}/lib/modules/${KERNEL_VERSION}/
}

PACKAGES = "wrt-libs wrt-utils kernel-module-wlcompat"
FILES_wrt-libs = "/usr/lib"
FILES_wrt-utils = "/usr/sbin /sbin"
FILES_kernel-module-wlcompat = "/lib/modules/"
RDEPENDS_wrt-utils = "wrt-libs"
