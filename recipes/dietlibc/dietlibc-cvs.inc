SRCDATE = "20110311"
PV = "0.32+cvs${SRCDATE}"

SRC_URI = " \
        cvs://cvs@cvs.fefe.de/cvs;method=pserver;module=dietlibc;date=${SRCDATE} \
        file://ccache.patch \
        file://ceil.patch \
        file://getrlimit.patch \
"

S = "${WORKDIR}/dietlibc"

# SMP build is broken
PARALLEL_MAKE = ""

# prefer the 'git' version which fixes lot of issues
DEFAULT_PREFERENCE = "-1"

# ARM EABI not fixable without complex patches
DEFAULT_PREFERENCE_arm = "-99"

do_configure_append () {
    install -d -m 0755 bin-${DIETLIBC_BUILD_ARCH}
    install -d -m 0755 bin-${DIETLIBC_TARGET_ARCH}

    sed -i -e 's!\$(CROSS)strip!$(STRIP)!g' Makefile
}
