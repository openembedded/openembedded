DESCRIPTION = "Drivers and utils for DXR3/Hollywood+ mpeg decoder cards""
DEPENDS = "gtk+"

# Be sure to have the I2C bitbanging interface enabled in your kernel config

SRC_URI = "${SOURCEFORGE_MIRROR}/dxr3/${PN}-${PV}.tar.gz \
           file://kernel-source-dir.diff;patch=1 \
          "

inherit module-base autotools

do_configure_prepend() {
        sed -i -e s:SEDME:${STAGING_KERNEL_DIR}:g modules/Makefile
}

do_compile_append() {
       cd ${S}/modules
       oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
                  KERNEL_SRC=${STAGING_KERNEL_DIR}    \
                  KERNEL_VERSION=${KERNEL_VERSION}    \
                  CC="${KERNEL_CC}" LD="${KERNEL_LD}" 
       cd ${S}
}

do_install_append() {
       cd ${S}/modules
       unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
       oe_runmake DEPMOD=echo INSTALL_MOD_PATH="${D}" CC="${KERNEL_CC}" LD="${KERNEL_LD}" modules_install
       cd ${S}
} 

PACKAGES =+ "em8300-modules"
FILES_em8300-modules = "${base_libdir}/modules"

pkg_postinst_append () {
        if [ -n "$D" ]; then
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_append () {
        update-modules || true
}


