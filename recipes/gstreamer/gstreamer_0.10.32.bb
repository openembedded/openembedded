require gstreamer.inc

SRC_URI[archive.md5sum] = "442bc3d37b8511a73379143e7531d726"
SRC_URI[archive.sha256sum] = "3bf4e46a186ee9a1f5e212aaf651d67cffb4f5f05345a7c99ae71d5d992be133"

SRC_URI += " \
             file://0001-add-GstQueryBuffers-query.patch \
             file://0002-gstevent-add-crop-event.patch \
             file://0003-basetransform-don-t-do-unnecessary-pad_alloc.patch \
"

EXTRA_OECONF += "ac_cv_func_register_printf_function=no"

