require jamvm.inc

SRC_URI += "file://debian-jni.patch;striplevel=0"

PR = "r3"

do_configure_prepend() {
  # Replaces the placeholder OE_LIBDIR_JNI with the JNI library directory
  # configured in OE.
  sed -i -e "s|OE_LIBDIR_JNI|${libdir_jni}|" src/dll.c
}

SRC_URI[md5sum] = "ce886163658d748113b0570dfae12aea"
SRC_URI[sha256sum] = "f2795ab62635df1c9bc6c4a7b90f53d0d846c0c26f5ec7b352f687506407ebd8"

