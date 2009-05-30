#define MAX_VMODES 4
#define FB_BPP 16

#define AF_CONTROL "\xAF\x20\xFF\x00\xAF\x20\x20\x00\xAF\x20\x21\0\xAF\x20\x22\0\xAF\x20\x26\x28\xAF\x20\x27\x00\xAF\x20\x28\x00\xAF\x20\xFF\xFF\xAF\xA0"
#define STD_CHANNEL        "\x57\xCD\xDC\xA7\x1C\x88\x5E\x15\x60\xFE\xC6\x97\x16\x3D\x47\xF2"

// as libdlo
#define BUF_HIGH_WATER_MARK 1024
#define BUF_SIZE 64*1024

// Data (and color functions) taken from libdlo (http://freedesktop.org/wiki/Software/libdlo)


/** Return red/green component of a 16 bpp colour number. */
#define DLO_RG16(red, grn) (uint8_t)((((red) & 0xF8) | ((grn) >> 5)) & 0xFF)

/** Return green/blue component of a 16 bpp colour number. */
#define DLO_GB16(grn, blu) (uint8_t)(((((grn) & 0x1C) << 3) | ((blu) >> 3)) & 0xFF)

/** Return 8 bpp colour number from red, green and blue components. */
#define DLO_RGB8(red, grn, blu) ((((red) << 5) | (((grn) & 3) << 3) | ((blu) & 7)) & 0xFF)

/** Return a 32 bpp colour number when given the three RGB components. */
#define DLO_RGB(red,grn,blu) (u32)(((red) & 0xFF) | (((grn) & 0xFF) << 8) | (((blu) & 0xFF) << 16))

/** Read the red component (0..255) of a 32 bpp colour. */
#define DLO_RGB_GETRED(col) (uint8_t)((col) & 0xFF)

/** Read the green component (0..255) of a 32 bpp colour. */
#define DLO_RGB_GETGRN(col) (uint8_t)(((col) >> 8) & 0xFF)

/** Read the blue component (0..255) of a 32 bpp colour. */
#define DLO_RGB_GETBLU(col) (uint8_t)(((col) >> 16) & 0xFF)


static u32 read_pixel_565(const uint8_t * const ptr, const bool swap)
{
  u32 col;
  uint16_t   *pix = (uint16_t *)ptr;
  uint8_t     red, grn, blu;

  col  = *pix;
  red  = (col & 0x001F) << 3;
  grn  = (col & 0x07E0) >> 3;
  blu  = (col & 0xF800) >> 8;
  red  = red | (red >> 5);
  grn  = grn | (grn >> 5);
  blu  = blu | (blu >> 5);

  return swap ? DLO_RGB(blu, grn, red) : DLO_RGB(red, grn, blu);
}

static u16 rgb16(u32 col)
{
  uint8_t red = DLO_RGB_GETRED(col);
  uint8_t grn = DLO_RGB_GETGRN(col);
  uint8_t blu = DLO_RGB_GETBLU(col);

  return (DLO_RG16(red, grn) << 8) + DLO_GB16(grn, blu);
}



struct dlfb_data {
        struct usb_device       *udev;
        struct usb_interface    *interface;
        struct urb *tx_urb, *ctrl_urb ;
        struct usb_ctrlrequest dr;
        struct fb_info *info;
        char *buf ;
        char *bufend;
        struct mutex bulk_mutex;
        char edid[128];
	int screen_size;
	int line_length;
};


struct dlfb_video_mode {

	int width ;
	int height;
	int bpp;
	int hz;

	char enable_data[146];
	char data[146];
};

struct dlfb_video_mode dlfb_video_modes[MAX_VMODES] ;

static void dlfb_bulk_callback(struct urb *urb) {

        struct dlfb_data *dev_info = urb->context;

        mutex_unlock(&dev_info->bulk_mutex);

}

static int dlfb_bulk_msg(struct dlfb_data *dev_info, int len) {

        int clen;

        /*
        mutex_lock(&dev_info->bulk_mutex);

        usb_fill_bulk_urb(dev_info->tx_urb, dev_info->udev, usb_sndbulkpipe(dev_info->udev, 1), dev_info->buf, len, dlfb_bulk_callback, dev_info);

        dev_info->tx_urb->actual_length = 0;

        return usb_submit_urb(dev_info->tx_urb, GFP_NOIO);
        */

        return usb_bulk_msg(dev_info->udev, usb_sndbulkpipe(dev_info->udev, 1), dev_info->buf, len, &clen, 0);
}



void dlfb_init_modes(void) {

	dlfb_video_modes[0].width = 800 ;
	dlfb_video_modes[0].height = 480 ;
	dlfb_video_modes[0].bpp = 16 ;
	dlfb_video_modes[0].hz = 60 ;
	memcpy(dlfb_video_modes[0].enable_data,"\x7A\x12\x36\x0B\xEF\x21\x74\xD1\xF0\x06\x8F\x38\xE8\x71\xB4\xCE",16);
	memcpy(dlfb_video_modes[0].data,"" \
        	"\x78\x67\x19\xF3\xB3\xD6\x5D\x7B\x4C\xCA\x26\x78\x41\x19\x19\xAC" \
        	"\xFF\x38\xB3\x10\x71\x89\x6A\xEC\xA8\xC1\x4F\x1F\x77\x86\x5D\x7E" \
        	"\xCE\xAF\x65\x7D\xFC\x30\x51\x67\x1F\x48\x30\x8E\x7A\x4B\x8A\xD4" \
        	"\xCB\x62\x45\x58\x5C\x22\x1D\x56\x6E\x2F\x60\xE2\x06\x6D\xA1\xE3" \
        	"\x82\x5F\x67\x95\x7A\x9F\x87\x43\xD8\x33\xEF\x0B\x5A\xDA\x09\x4F" \
        	"\xD7\x25\x6F\xBC\xF8\xC7\x09\x9C\x12\xC3\xA7\x6F\xE7\xED\xA8\x70" \
        	"\x8C\xB9\x65\x53\xDD\xA6\x7D\xDE\xD9\x4F\xDD\xD4\x6F\x28\xD6\x14" \
        	"\xDC\x2D\x41\x53\x33\xD9\x0A\x86\x11\x3C\x41\x5A\x56\x48\xF9\x85" \
        	"\x2B\x2F\x22\x66\x20\x39\xDA\xA1\x50\xCB\x5A\x58\x7D\x97\xFA\x2C" \
        	"\x64\x9D",146);

	dlfb_video_modes[1].width = 1024 ;
	dlfb_video_modes[1].height = 768 ;
	dlfb_video_modes[1].bpp = 16 ;
	dlfb_video_modes[1].hz = 60 ;
	memcpy(dlfb_video_modes[1].enable_data,"\xB6\xF8\xFC\x00\xF3\xE4\x81\x1E\xC5\x60\xA3\x79\xE5\x35\xC5\x15",16);
	memcpy(dlfb_video_modes[1].data,"" \
		"\xDD\x2A\x3A\x49\xE9\x99\xE3\xC8\xA0\xBA\x23\x3A\x3D\xEB\x21\xE4" \
        	"\xA5\x54\x25\x0D\x51\xCC\xE6\x52\xA7\xD7\xCD\xFA\xD5\x9B\x5B\x41" \
        	"\x0B\x49\xAB\xC6\xE3\x1A\xF2\x87\x81\x32\xF0\x3E\x40\x00\x51\x40" \
        	"\x9E\x94\xF1\x22\xEE\xAC\xB2\xA2\x6B\x4D\xC4\x41\x5A\x9C\x45\x62" \
        	"\x4F\x4E\x61\xDB\x1F\x0E\x79\x66\xE2\x20\x83\x9E\x2C\xAB\x28\x38" \
        	"\xAC\xC1\x22\x81\xA5\x69\xFD\xFB\x26\x15\xF9\xC9\xFA\x90\xF2\x66" \
        	"\x85\xC5\xAA\xA6\x4D\x8B\xC8\xA6\x03\x32\xDF\x98\xA9\x77\x9E\x57" \
        	"\xEA\xC9\x9E\x29\xED\xFC\xC4\x78\x26\x0B\x2E\xC2\x41\x7C\x4A\xA3" \
        	"\xAB\x66\x01\xA0\xE5\xA4\x8B\x80\xA0\x53\xE5\x5D\x59\x63\x62\xE8" \
        	"\xFE\x6B",146);

	dlfb_video_modes[2].width = 1280 ;
	dlfb_video_modes[2].height = 1024 ;
	dlfb_video_modes[2].bpp = 16 ;
	dlfb_video_modes[2].hz = 60 ;
	memcpy(dlfb_video_modes[2].enable_data,"\x6A\xF0\x37\x50\x63\xEF\xD2\xA9\x6F\x75\x72\xBB\xC7\x7B\x6F\x1A",16);
	memcpy(dlfb_video_modes[2].data,"" \
		"\x23\x4A\x78\x7C\xD1\xB8\x0E\x6B\x15\x93\x96\x77\x78\x44\xCC\x16" \
        	"\x7F\xE3\xD7\x39\x3F\x2E\x99\xD2\xB9\x68\x8E\xC4\x1A\x9B\xF4\x35" \
        	"\x61\xB5\x48\x5C\x94\xA6\x84\xB2\x88\x2B\x47\x84\x84\x73\x7F\x2C" \
        	"\xD0\xC4\x3D\x5D\x20\x61\x4A\xB1\x73\x4C\xDD\x6A\xB4\xFD\xE9\x94" \
        	"\x3C\xD1\x44\x0A\x08\xCD\xF5\xE5\xBD\x0D\x99\xCD\x9C\x2A\xC9\x06" \
        	"\x1D\x22\x1C\xB1\x9A\x94\x95\x65\x3C\x43\x19\x73\x83\xF7\x51\x1F" \
        	"\x5C\x3C\xE1\x59\xD5\xC3\xF2\x27\x28\xCE\x22\x7B\x2A\x70\x04\xE4" \
        	"\xD9\xFE\x8A\x6E\x28\x27\xC5\x40\x4E\xF8\x83\x5B\x82\x41\xA6\x62" \
        	"\xC1\x73\x3A\x5C\xF6\x90\x43\x39\xF2\xF5\x74\x80\x74\x44\xBD\xB1" \
        	"\x08\x53",146);

	dlfb_video_modes[3].width = 1400 ;
	dlfb_video_modes[3].height = 1050 ;
	dlfb_video_modes[3].bpp = 16 ;
	dlfb_video_modes[3].hz = 60 ;
	memcpy(dlfb_video_modes[3].enable_data,"\x95\xCB\x91\xE5\xA8\x28\xFB\x87\xD5\x92\x1C\x44\x66\x57\x8A\x98",16);
	memcpy(dlfb_video_modes[3].data,"" \
		"\xC6\x8C\x42\x4C\x95\xDA\xB4\x2F\xBD\xD9\x9E\xAD\x8F\x7B\x69\x15" \
        	"\x1B\xDA\x06\x79\x23\x9E\x94\xF2\xC2\xE9\xBB\x34\x13\x6B\x9B\xB2" \
        	"\xC1\x4E\xD8\x69\x81\x49\x6E\x64\xAF\xB2\x4E\x69\x24\x1A\xA8\xBB" \
        	"\x4E\x11\x75\x38\xE6\xC9\x3D\xE9\x9A\xCC\x3B\xAA\x1F\xC4\x97\xD5" \
        	"\x4A\x9D\xAA\xE7\x04\xF0\xB6\xD4\xBD\xE4\x41\xCF\xF8\xA2\x77\x0B" \
        	"\x46\x9D\x3A\xBD\x73\xC0\x64\x76\x84\x2B\xD7\x11\xF3\x43\xB5\xF6" \
        	"\xE9\x0B\xB3\x4E\x2B\x80\x98\x15\xDC\xDA\x46\xE8\xEC\xBD\x0B\x0E" \
        	"\x64\x20\xF7\x17\x17\x33\x75\xBA\x30\x26\xDD\xFA\xA0\x99\x23\x11" \
        	"\xF1\xDE\x80\xB7\xD6\xB0\xB7\xA2\xA9\xBD\x6D\x29\x42\x74\x75\x73" \
        	"\xC5\x27",146);

}

int dlfb_set_video_mode(struct dlfb_data *dev_info, int width, int height) {

	int i, ret;

	for(i=0;i<MAX_VMODES;i++) {
		printk("INIT VIDEO %d %d %d\n",i, dlfb_video_modes[i].width, dlfb_video_modes[i].height);
		if (dlfb_video_modes[i].width == width && dlfb_video_modes[i].height == height) {

			memcpy(dev_info->buf, STD_CHANNEL, 16);
        		ret = usb_control_msg(dev_info->udev, usb_sndctrlpipe(dev_info->udev, 0), 0x12, (0x02 << 5), 0, 0, dev_info->buf, 16, 0);
        		printk("ret control msg 1 (STD_CHANNEL): %d\n", ret);

        		memcpy(dev_info->buf, AF_CONTROL, sizeof(AF_CONTROL)-1);
        		ret = dlfb_bulk_msg(dev_info, sizeof(AF_CONTROL)-1);
        		printk("ret bulk 1: %d\n", ret);


        		memcpy(dev_info->buf, &dlfb_video_modes[i].enable_data, 16);
        		ret = usb_control_msg(dev_info->udev, usb_sndctrlpipe(dev_info->udev, 0), 0x12, (0x02 << 5), 0, 0, dev_info->buf, 16, 0);
        		printk("ret control msg 2: %d\n", ret);


        		// MODE_DATA
        		memcpy(dev_info->buf, &dlfb_video_modes[i].data, 146);
        		ret = dlfb_bulk_msg(dev_info, 146);
        		printk("ret bulk 2: %d\n", ret);

        		memcpy(dev_info->buf, STD_CHANNEL, sizeof(STD_CHANNEL)-1);
        		ret = usb_control_msg(dev_info->udev, usb_sndctrlpipe(dev_info->udev, 0), 0x12, (0x02 << 5), 0, 0, dev_info->buf, sizeof(STD_CHANNEL)-1, 0);
        		printk("ret control msg 3: %d\n", ret);

        		// flush
        		ret = dlfb_bulk_msg(dev_info, 0);
        		printk("ret bulk 3: %d\n", ret);
	
			dev_info->screen_size = width*height*(FB_BPP/8) ;
			dev_info->line_length = width*(FB_BPP/8) ;

			return 0;
		}
	}

	return -1 ;
}
