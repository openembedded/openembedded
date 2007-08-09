dsmg600_pack_image () {
	install -d ${DEPLOY_DIR_IMAGE}/firmupgrade
	install -m 0755 ${DEPLOY_DIR_IMAGE}/zImage-dsmg600${SITEINFO_ENDIANESS} \
		${DEPLOY_DIR_IMAGE}/firmupgrade/ip-ramdisk
	install -m 0644 ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
		${DEPLOY_DIR_IMAGE}/firmupgrade/rootfs.gz
	touch ${DEPLOY_DIR_IMAGE}/firmupgrade/usr.cramfs
	chmod 0644 ${DEPLOY_DIR_IMAGE}/firmupgrade/usr.cramfs
	echo "hwid=1.0.1"      >${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo "model=dsm-g600" >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo "vendor=dlink"   >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	echo ""               >>${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	chmod 0744 ${DEPLOY_DIR_IMAGE}/firmupgrade/version.msg
	tar -c -f ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-dsmg600.bin \
		-C ${DEPLOY_DIR_IMAGE} firmupgrade
	rm -rf ${DEPLOY_DIR_IMAGE}/firmupgrade
}

# dsmg600 is not a separate machine - use the nslu2 machine override.
IMAGE_POSTPROCESS_COMMAND_nslu2 += "dsmg600_pack_image; "
