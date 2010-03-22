DESCRIPTION = "Framebuffer console driver for displaylink based usb devices"
LICENSE = "GPLv2"

# Make sure you have:
# CONFIG_FB_DEFERRED_IO=y
# CONFIG_FB_VIRTUAL=y
# CONFIG_FB_MODE_HELPERS=y
# CONFIG_FB_SYS_IMAGEBLIT=y
# CONFIG_FB_SYS_IMAGEBLIT_MODULE=y
# CONFIG_FB_SYS_COPYAREA=y
# CONFIG_FB_SYS_COPYAREA_MODULE=y
# CONFIG_FB_SYS_FILLRECT=y
# CONFIG_FB_SYS_FILLRECT_MODULE=y
# enabled in your kernel

PV = "0.4"
PR_append = "b+gitr${SRCREV}"

SRCREV = "c01f96f2de105c1898cbd1708fe5472ca0f7a7e2"
SRC_URI = "git://git.plugable.com/webdav/udlfb;protocol=http;branch=master"

inherit module

S = "${WORKDIR}/git"

MODULE_MAKE_FLAGS += " -C ${STAGING_KERNEL_DIR} SUBDIRS=${S}"


