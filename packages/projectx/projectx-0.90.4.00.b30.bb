DESCRIPTION = "Handle & repair many DVB radio & television stream types."
MAINTAINER = "Andreas Frisch <andreas.frisch@multimedia-labs.de>"
LICENSE="GPL-2"
SECTION = "optional"
DEPENDS = ""
RDEPENDS = ""
PN = "projectx"
PV = "0.90.4.00.b30"
PR = "r0"
SRCDATE = "20090618"

SRC_URI = "cvs://anonymous@project-x.cvs.sourceforge.net/cvsroot/project-x;module=Project-X;method=pserver\
           file://dreambox-headless.patch;patch=1;pnum=0 \
           file://Makefile"

PRECOMPILED_N = "${PN}-mipsel-bin-20090618-${PV}.tar.bz2"
PRECOMPILED_URI = "http://dreamboxupdate.com/download/opendreambox/${PRECOMPILED_N}"

do_unpack_extra() {
	mv ${WORKDIR}/Project-X ${S}
	for dir in ${S}/src/net/sourceforge/dvb/projectx/*; do
	cd $dir
		for x in *.java; do
			if [ "$x" != "*.java" ]; then
				echo "Converting CP1250 to UTF-8 in $x"
				iconv --from-code=CP1250 --to-code=UTF-8 < "$x" > "tmp.$x"
				mv "tmp.$x" "$x"
			fi
		done
	done
	mv ${WORKDIR}/Makefile ${S}/src
}
addtask unpack_extra after do_unpack before do_patch

do_compile_prepend() {
	export CROSS_LIBDIR="${CROSS_DIR}/${TARGET_SYS}/lib"
	export GCJ_ARCH=""
	for gcjarchives in libgcj.a libgij.a; do
		if test -e ${CROSS_LIBDIR}/$gcjarchives; then
			export GCJ_ARCHIVES="${GCJ_ARCHIVES} ${CROSS_LIBDIR}/$gcjarchives"
		fi
	done
	if [ "${GCJ_ARCHIVES}" = "" ]; then
		echo gcj not found, downloading statically linked binary
		exit
	else
		echo ${GCJ_ARCHIVES} found, compiling...
	fi
}

do_compile() {
	export JFLAGS="-g0 -O3 -march=mips32"
	export CROSS_COMPILE=${TARGET_PREFIX}
	cd ${S}/src
	make projectx
}

do_download_precompiled_binary() {
	if ! test -e ${S}/src/projectx; then
		cd ${S}/src
		wget ${PRECOMPILED_URI}
		tar -xjf ${PRECOMPILED_N}
	fi
}
addtask download_precompiled_binary after do_compile before do_install

do_install() {
	install -d ${D}/${bindir}
	install -m 755 ${S}/src/projectx ${D}/${bindir}/
}
