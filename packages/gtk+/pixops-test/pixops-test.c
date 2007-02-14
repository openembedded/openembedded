#include <gtk/gtk.h>
#include <gdk-pixbuf/gdk-pixbuf.h>
#include <stdlib.h>

static gdouble total_seconds = 0.0;

/* randomly colour each pixel */
static void
fill_pixbuf (GdkPixbuf *buf)
{
	int width, height, rowstride, n_channels;
	int x,y,n;
	guchar *pixels, *p;

	g_assert (gdk_pixbuf_get_bits_per_sample (buf) == 8);

	n_channels = gdk_pixbuf_get_n_channels (buf);
	width = gdk_pixbuf_get_width (buf);
	height = gdk_pixbuf_get_height (buf);
	rowstride = gdk_pixbuf_get_rowstride (buf);
	pixels = gdk_pixbuf_get_pixels (buf);

	for (x=0; x<width; x++) {
		for (y=0; y<height; y++) {
			p = pixels + (y*rowstride) + (x*n_channels);
			for (n=0; n<n_channels; n++) {
				p[n] = (random()*255)/RAND_MAX;
			}
		}
	}
}

int
main (int argc, char **argv)
{
        GTimer *timer;
	int i,j;

        gtk_init (&argc, &argv);


	GdkPixbuf *pixbuf[4], *ret;
	pixbuf[0] = gdk_pixbuf_new (GDK_COLORSPACE_RGB, FALSE, 8, 400, 600);
	pixbuf[1] = gdk_pixbuf_new (GDK_COLORSPACE_RGB, FALSE, 8, 40, 60);
	pixbuf[2] = gdk_pixbuf_new (GDK_COLORSPACE_RGB, TRUE, 8, 400, 600);
	pixbuf[3] = gdk_pixbuf_new (GDK_COLORSPACE_RGB, TRUE, 8, 40, 60);

	for (j=0; j<4; j++)
		fill_pixbuf (pixbuf[j]);

	timer = g_timer_new ();
	g_timer_start (timer);

	for (i = 0; i < 10 ; i++) {
		for (j=0; j<4; j++) {
			ret = gdk_pixbuf_scale_simple (pixbuf[j], 700, 900, GDK_INTERP_BILINEAR);
			gdk_pixbuf_unref (ret);
			ret = gdk_pixbuf_scale_simple (pixbuf[j], 20, 50, GDK_INTERP_BILINEAR);
			gdk_pixbuf_unref (ret);
		}
	}
	g_timer_stop (timer);

	total_seconds += g_timer_elapsed (timer, NULL);
        
        g_print ("time spent scaling (in seconds): %lf\n",  total_seconds );

        return 0;
}
