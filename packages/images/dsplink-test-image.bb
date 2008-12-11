# This image is a bare-bones image to test the TI dsplink modules

require minimal-image.bb
IMAGE_INSTALL += "dsplink-module ti-cmemk-module"

export IMAGE_BASENAME = "dsplink-testing-image"

