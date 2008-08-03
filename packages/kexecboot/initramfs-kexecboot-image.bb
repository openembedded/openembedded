#initramfs image which mounts the rootfilesystem and kexecs a kernel from there

IMAGE_FSTYPES += " cpio.gz"
inherit image

export IMAGE_BASENAME = "initramfs-kexecboot-image"

IMAGE_INSTALL = "klibc-utils-static-sh klibc-utils-static-mount kexec-static initramfs-kexecboot"
IMAGE_LINGUAS = ""
