require u-boot-omap3.inc

DEFAULT_PREFERENCE_ti816x = "1"
BRANCH = "ti816x-master"
COMPATIBLE_MACHINE = "ti816x"

# Corresponds to v2010.06_TI816XPSP_04.00.00.07"
SRCREV = "5b8934eb4ed892dbb40470c143c523b5bbd20cdc"

UVER = "2010.06"
PSPREL = "04.00.00.07"

PR = "r3"

UBOOT_MACHINE = "ti8168_evm_config"

TI_UBOOT_BINARY = "u-boot.noxip.bin"

do_compile_append () {
        unset LDFLAGS
        unset CFLAGS
        unset CPPFLAGS
        oe_runmake u-boot.ti
}

do_install_append () {
        install ${S}/${TI_UBOOT_BINARY} ${D}/boot/${TI_UBOOT_BINARY}
}

do_deploy_append () {
        install ${S}/${TI_UBOOT_BINARY} ${DEPLOY_DIR_IMAGE}/${TI_UBOOT_BINARY}
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${TI_UBOOT_BINARY}

}

