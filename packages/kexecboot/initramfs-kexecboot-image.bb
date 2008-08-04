#initramfs image which mounts the rootfilesystem and kexecs a kernel from there

IMAGE_FSTYPES += " cpio.gz"
inherit image

export IMAGE_BASENAME = "initramfs-kexecboot-image"

IMAGE_INSTALL = "initramfs-kexecboot"
IMAGE_LINGUAS = ""
