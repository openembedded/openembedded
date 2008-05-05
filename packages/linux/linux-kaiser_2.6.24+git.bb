require linux.inc

PV = "2.6.24+git${SRCREV}"

COMPATIBLE_MACHINE = "htckaiser"

SRC_URI = "git://git.android.com/kernel.git;branch=android-msm;protocol=git \
           http://baliniak.pl/android/kernel.diff;patch=1"

S = "${WORKDIR}/git"

do_configure_prepend() {
	cp .config ../defconfig
}

