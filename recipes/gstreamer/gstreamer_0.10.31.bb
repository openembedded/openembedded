require gstreamer.inc

PR = "r2"

SRC_URI[archive.md5sum] = "a21fb08bdb578d972c7c14e77da8fbb6"
SRC_URI[archive.sha256sum] = "7f737e6d047c1ebeb4e1e0725fc377c5d9f12ee89186de7960be3cbba709ab84"

SRC_URI += " \
             file://0001-add-GstQueryBuffers-query.patch \
             file://0002-gstevent-add-crop-event.patch \
             file://0003-basetransform-don-t-do-unnecessary-pad_alloc.patch \
"

EXTRA_OECONF += "ac_cv_func_register_printf_function=no"

