#initramfs image which mounts the rootfilesystem and kexecs a kernel from there

inherit image

export IMAGE_BASENAME = "initramfs-kexec-image"

IMAGE_INSTALL = "klibc-utils-static-sh klibc-utils-static-mount kexec-static initramfs-kexec"
IMAGE_FSTYPES += " cpio.gz"
IMAGE_LINGUAS = ""
