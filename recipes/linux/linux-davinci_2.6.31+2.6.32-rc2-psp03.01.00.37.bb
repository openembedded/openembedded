require linux-davinci.inc

SRCREV = "DEV.DaVinciPSP.03.XX.00.37"

KVER = "2.6.32-rc2"
PSPREL = "03.01.00.37"

SRC_URI += " \
    file://0001-changed-driver-for-MMAP-buffer.patch \
    file://0002-Patch-for-adding-imagesize-corrected-for-MMAP-buffer.patch \
    file://0003-Patch-for-capture-driver-MMAP-buffer-allocation.-The.patch \
    file://0004-Patch-for-vpif-capture-driver-to-get-the-right-size-.patch \
    file://0005-DM365-MMAP-buffer-allocation-for-display-driver.patch \
    file://0006-DM365-capture-MMAP-buffer-allocation.patch \
    file://0007-Patch-MMAP-buffer-bufsize-support-upto-1080p-resolut.patch \
    file://0008-DM365-davinci_video-Enable-VENC-clock-for-COMPONEN.patch \
    file://0009-Implement-V4L2-PARM-display-ioctls.patch \
    file://0010-Replace-usage-of-cbcr_ofst-with-davinci_fb_desc.patch \
    file://0011-dm365-Add-custom-display-ioctl-VIDIOC_S_YDOFST.patch \
    "
