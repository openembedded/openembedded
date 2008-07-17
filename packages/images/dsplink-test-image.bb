# This image is a bare-bones image to test the TI dsplink modules

require minimal-image.bb
IMAGE_INSTALL += "dsplink"

export IMAGE_BASENAME = "dsplink-testing-image"

