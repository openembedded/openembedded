/*
  A SL811 CLIENT DRIVER for linux 2.4.x
  Filename: sl811_cs.c
  Version:  0.0.2
  Author:   Yukio Yamamoto

  Port to sl811-hcd and 2.6.x by
    Botond Botyanszki <boti()rocketmail.com>
    Simon Pickering

  Last update: 2005-05-05
*/

#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/sched.h>
#include <linux/ptrace.h>
#include <linux/slab.h>
#include <linux/string.h>
#include <linux/timer.h>
#include <linux/ioport.h>
#include <linux/version.h>
#include <asm/io.h>
#include <asm/system.h>

#include <pcmcia/version.h>
#include <pcmcia/cs_types.h>
#include <pcmcia/cs.h>
#include <pcmcia/cistpl.h>
#include <pcmcia/cisreg.h>
#include <pcmcia/ds.h>

#include <linux/usb_sl811.h>

MODULE_AUTHOR("Botond Botyanszki");
MODULE_DESCRIPTION("REX-CFU1 PCMCIA driver for 2.6");
MODULE_LICENSE("GPL");


/*====================================================================*/
/* MACROS                                                             */
/*====================================================================*/

#if defined(DEBUG) || defined(CONFIG_USB_DEBUG)
#define DBG(n, args...) printk(KERN_DEBUG "sl811_cs: " args)
#else
#define DBG(n, args...) do{}while(0)
#endif

#define INFO(args...) printk(KERN_INFO "sl811_cs: " args)

/*static char *version = "sl811_cs.c 0.04 2005/04/27 00:00:00 (OpenZaurus Team)";*/

#define INT_MODULE_PARM(n, v) static int n = v; MODULE_PARM(n, "i")

#define CS_CHECK(fn, ret) \
	do { last_fn = (fn); if ((last_ret = (ret)) != 0) goto cs_failed; } while (0)

/*====================================================================*/
/* VARIABLES                                                          */
/*====================================================================*/

static dev_info_t dev_info  = "sl811_cs";
static dev_link_t *dev_list = NULL;

static ioaddr_t base_addr   = 0x00000000;
static int irq              = -1;

static int irq_list[4] = { -1 };
MODULE_PARM(irq_list, "1-4i");
INT_MODULE_PARM(free_ports, 0);
INT_MODULE_PARM(irq_mask, 0xdeb8);

/*====================================================================*/
/* PROTO TYPES                                                        */
/*====================================================================*/

static dev_link_t* sl811_cs_attach(void);
static void        sl811_cs_detach(dev_link_t *);
static void        sl811_cs_config(dev_link_t *link);
static void        sl811_cs_release(dev_link_t *arg);
static int         sl811_cs_event(event_t event, int priority,
				  event_callback_args_t *args);

/*====================================================================*/
/* PROTO TYPES                                                        */
/*====================================================================*/

typedef struct local_info_t {
  dev_link_t		link;
  dev_node_t		node;
} local_info_t;

static struct pcmcia_driver sl811_driver = {
	.owner		= THIS_MODULE,
	.drv		= {
		.name	= "sl811_cs",
	},
	.attach		= sl811_cs_attach,
	.detach		= sl811_cs_detach,
};
extern struct device_driver sl811h_driver;

static struct sl811_platform_data platform_data;
static struct res {
	struct resource irq_res;
	struct resource addr_res;
	struct resource data_res;
} resources;
static struct platform_device platform_dev = {
	.name              = "sl811_cs",
	.id                = 0,
	.num_resources     = 0,
	.dev.dma_mask      = 0,
	.dev.platform_data = &platform_data,
	.dev.bus_id        = "sl811-hcd",
	.dev.driver        = &sl811h_driver
};

/*====================================================================*/
/* EXTERNAL FUNCTIONS                                                 */
/*====================================================================*/
int sl811h_probe(void *dev);

/*====================================================================*/


/*====================================================================*/
static void release_platform_dev(struct device * dev) {
	DBG(0, "sl811_cs platform_dev release\n");
}

/*====================================================================*/
static dev_link_t *sl811_cs_attach(void)
{
  local_info_t *local;
  dev_link_t *link;
  client_reg_t client_reg;
  int ret, i;
  
  local = kmalloc(sizeof(local_info_t), GFP_KERNEL);
  if (!local) return NULL;
  memset(local, 0, sizeof(local_info_t));
  link = &local->link; link->priv = local;

  /* Initialize */
  link->irq.Attributes = IRQ_TYPE_EXCLUSIVE;
  link->irq.IRQInfo1 = IRQ_INFO2_VALID|IRQ_LEVEL_ID;
  if (irq_list[0] == -1)
    link->irq.IRQInfo2 = irq_mask;
  else
    for (i = 0; i < 4; i++)
      link->irq.IRQInfo2 |= 1 << irq_list[i];
  link->irq.Handler = NULL;
    
  link->conf.Attributes = 0;
  link->conf.Vcc = 33;
  link->conf.IntType = INT_MEMORY_AND_IO;
  
  /* Register with Card Services */
  link->next = dev_list;
  dev_list = link;
  client_reg.dev_info = &dev_info;
  client_reg.Attributes = INFO_IO_CLIENT | INFO_CARD_SHARE;
  client_reg.EventMask =
    CS_EVENT_CARD_INSERTION | CS_EVENT_CARD_REMOVAL |
    CS_EVENT_RESET_PHYSICAL | CS_EVENT_CARD_RESET |
    CS_EVENT_PM_SUSPEND | CS_EVENT_PM_RESUME;
  client_reg.event_handler = &sl811_cs_event;
  client_reg.Version = 0x0210;
  client_reg.event_callback_args.client_data = link;
  ret = pcmcia_register_client(&link->handle, &client_reg);
  if (ret != CS_SUCCESS) {
	  cs_error(link->handle, RegisterClient, ret);
	  sl811_cs_detach(link);
	  return NULL;
  }
  
  return link;
} /* sl811_cs_attach */

/*====================================================================*/
static void sl811_cs_detach(dev_link_t *link)
{
  dev_link_t **linkp;

  DBG(0, "sl811_cs_detach(0x%p)\n", link);
    
  /* Locate device structure */
  for (linkp = &dev_list; *linkp; linkp = &(*linkp)->next)
    if (*linkp == link) break;
  if (*linkp == NULL)
    return;
  
#if LINUX_VERSION_CODE < KERNEL_VERSION(2,6,0) 
  if (link->state & DEV_CONFIG) {
#ifdef PCMCIA_DEBUG
    printk(KERN_DEBUG "sl811_cs: detach postponed, '%s' "
	   "still locked\n", link->dev->dev_name);
#endif
    link->state |= DEV_STALE_LINK;
    return;
  }
#endif

  /* Break the link with Card Services */
  if (link->handle)
    pcmcia_deregister_client(link->handle);
  
  /* Unlink device structure, and free it */
  *linkp = link->next;
  /* This points to the parent local_info_t struct */
  kfree(link->priv);
  
} /* sl811_cs_detach */


/*====================================================================*/
static int sl811_hc_init(void)
{
	/* set up the device structure */
	resources.irq_res.flags = IORESOURCE_IRQ;
	resources.irq_res.start = irq;

	resources.addr_res.flags = IORESOURCE_MEM;
	resources.addr_res.start = base_addr;
	resources.addr_res.end = base_addr + 1;

	resources.data_res.flags = IORESOURCE_MEM;
	resources.data_res.start = base_addr + 1;
	resources.data_res.end   = base_addr + 4;

	platform_dev.dev.release = release_platform_dev;
	platform_device_register(&platform_dev);
	/* FIXME: we register the platform device with 0 resources 
	 otherwise the unregister call won't work*/

	platform_dev.num_resources = 3;
	platform_dev.resource      = (struct resource *) &resources;

	/* try to initialize the host controller */
	if (sl811h_probe(&platform_dev.dev) != 0) {
		DBG(0, "sl811h_probe() didn't return 0\n");
		return 0;
	}
	return 1;
}


/*====================================================================*/
static void sl811_cs_config(dev_link_t *link)
{
  client_handle_t handle = link->handle;
  local_info_t *dev = link->priv;
  tuple_t tuple;
  cisparse_t parse;
  int last_fn, last_ret;
  u_char buf[64];
  config_info_t conf;
  cistpl_cftable_entry_t dflt = { 0 };

  DBG(0, "sl811_cs_config(0x%p)\n", link);
  
  tuple.DesiredTuple = CISTPL_CONFIG;
  tuple.Attributes = 0;
  tuple.TupleData = buf;
  tuple.TupleDataMax = sizeof(buf);
  tuple.TupleOffset = 0;
  CS_CHECK(GetFirstTuple, pcmcia_get_first_tuple(handle, &tuple));
  CS_CHECK(GetTupleData, pcmcia_get_tuple_data(handle, &tuple));
  CS_CHECK(ParseTuple, pcmcia_parse_tuple(handle, &tuple, &parse));
  link->conf.ConfigBase = parse.config.base;
  link->conf.Present = parse.config.rmask[0];
    
  /* Configure card */
  link->state |= DEV_CONFIG;

  /* Look up the current Vcc */
  CS_CHECK(GetConfigurationInfo, pcmcia_get_configuration_info(handle, &conf));
  link->conf.Vcc = conf.Vcc;
  
  tuple.DesiredTuple = CISTPL_CFTABLE_ENTRY;
  CS_CHECK(GetFirstTuple, pcmcia_get_first_tuple(handle, &tuple));
  while (1) {
    cistpl_cftable_entry_t *cfg = &(parse.cftable_entry);
	if (pcmcia_get_tuple_data(handle, &tuple) != 0 ||
		pcmcia_parse_tuple(handle, &tuple, &parse) != 0)
		goto next_entry;

    if (cfg->flags & CISTPL_CFTABLE_DEFAULT) {
      dflt = *cfg;
    }

    if (cfg->index == 0) goto next_entry;    

    link->conf.ConfigIndex = cfg->index;
    
    /* Does this card need audio output? */
    if (cfg->flags & CISTPL_CFTABLE_AUDIO) {
      link->conf.Attributes |= CONF_ENABLE_SPKR;
      link->conf.Status = CCSR_AUDIO_ENA;
    }
    
    /* Use power settings for Vcc and Vpp if present */
    /*  Note that the CIS values need to be rescaled */
    if (cfg->vcc.present & (1<<CISTPL_POWER_VNOM)) {
      if (conf.Vcc != cfg->vcc.param[CISTPL_POWER_VNOM]/10000) {
	goto next_entry;
      }
    } else if (dflt.vcc.present & (1<<CISTPL_POWER_VNOM)) {
      if (conf.Vcc != dflt.vcc.param[CISTPL_POWER_VNOM]/10000) {
	goto next_entry;
      }
    }
    
    if (cfg->vpp1.present & (1<<CISTPL_POWER_VNOM))
      link->conf.Vpp1 = link->conf.Vpp2 =
	cfg->vpp1.param[CISTPL_POWER_VNOM]/10000;
    else if (dflt.vpp1.present & (1<<CISTPL_POWER_VNOM))
      link->conf.Vpp1 = link->conf.Vpp2 =
	dflt.vpp1.param[CISTPL_POWER_VNOM]/10000;
    
    /* Do we need to allocate an interrupt? */
    if (cfg->irq.IRQInfo1 || dflt.irq.IRQInfo1)
      link->conf.Attributes |= CONF_ENABLE_IRQ;
    
    /* IO window settings */
    link->io.NumPorts1 = link->io.NumPorts2 = 0;
    if ((cfg->io.nwin > 0) || (dflt.io.nwin > 0)) {
      cistpl_io_t *io = (cfg->io.nwin) ? &cfg->io : &dflt.io;

      link->io.Attributes1 = IO_DATA_PATH_WIDTH_8;
      link->io.IOAddrLines = io->flags & CISTPL_IO_LINES_MASK;
      link->io.BasePort1 = io->win[0].base;
      link->io.NumPorts1 = io->win[0].len;

      if (pcmcia_request_io(link->handle, &link->io) != 0)
	      goto next_entry;
    }
    break;
    
  next_entry:
    if (link->io.NumPorts1)
      pcmcia_release_io(link->handle, &link->io);
	  last_ret = pcmcia_get_next_tuple(handle, &tuple);
  }
  
  if (link->conf.Attributes & CONF_ENABLE_IRQ)
    CS_CHECK(RequestIRQ, pcmcia_request_irq(link->handle, &link->irq));
  
  CS_CHECK(RequestConfiguration, pcmcia_request_configuration(link->handle, &link->conf));
  
  if (free_ports) {
    if (link->io.BasePort1)
      release_region(link->io.BasePort1, link->io.NumPorts1);
  }

  sprintf(dev->node.dev_name, "cf_usb0");
  dev->node.major = dev->node.minor = 0;
  link->dev = &dev->node;
  
  printk(KERN_INFO "%s: index 0x%02x: Vcc %d.%d",
	 dev->node.dev_name, link->conf.ConfigIndex,
	 link->conf.Vcc/10, link->conf.Vcc%10);
  if (link->conf.Vpp1)
    printk(", Vpp %d.%d", link->conf.Vpp1/10, link->conf.Vpp1%10);
  if (link->conf.Attributes & CONF_ENABLE_IRQ) {
    printk(", irq %d", link->irq.AssignedIRQ);
    irq = link->irq.AssignedIRQ;
  }

  if (link->io.NumPorts1) {
    printk(", io 0x%04x-0x%04x", link->io.BasePort1,
	   link->io.BasePort1+link->io.NumPorts1-1);
    base_addr = link->io.BasePort1;
  }

  printk("\n");
  
  link->state &= ~DEV_CONFIG_PENDING;

  /* Release resources claimed by PCMCIA for the sl811h driver */
  release_region(link->io.BasePort1, link->io.NumPorts1);
  
  if (sl811_hc_init() == 0) goto cs_failed;

  return;
  
 cs_failed:
  printk("sl811_cs_config failed\n");
  cs_error(link->handle, last_fn, last_ret);
  sl811_cs_release(link);
  link->state &= ~DEV_CONFIG_PENDING;

} /* sl811_cs_config */

/*====================================================================*/
static void sl811_cs_release(dev_link_t * link)
{

  DBG(0, "sl811_cs_release(0x%p)\n", link);
  
  if (link->open) {
    DBG(1, "sl811_cs: release postponed, '%s' still open\n",
	  link->dev->dev_name);
    link->state |= DEV_STALE_CONFIG;
    return;
  }

  /* request IO, because PCMCIA thinks it has claimed it */
  request_region(link->io.BasePort1, link->io.NumPorts1, "sl811_cs");

  /* Unlink the device chain */
  link->dev = NULL;
  
  pcmcia_release_configuration(link->handle);
  if (link->io.NumPorts1)
    pcmcia_release_io(link->handle, &link->io);
  if (link->irq.AssignedIRQ)
    pcmcia_release_irq(link->handle, &link->irq);
  link->state &= ~DEV_CONFIG;
  
  if (link->state & DEV_STALE_LINK)
    sl811_cs_detach(link);

  /* FIXME: if the unregister call frees up the resources, it oopses
   so we pretend to have 0 resources */
  platform_dev.num_resources = 0;
  platform_dev.resource      = NULL;

  platform_device_unregister(&platform_dev);

} /* sl811_cs_release */

/*====================================================================*/
static int sl811_cs_event(event_t event, int priority, event_callback_args_t *args)
{
  dev_link_t *link = args->client_data;
    
  DBG(1, "sl811_cs_event(0x%06x)\n", event);
    
  switch (event) {
  case CS_EVENT_CARD_REMOVAL:
    link->state &= ~DEV_PRESENT;
    if (link->state & DEV_CONFIG) {
      sl811_cs_release(link);
    }
    break;

  case CS_EVENT_CARD_INSERTION:
    link->state |= DEV_PRESENT | DEV_CONFIG_PENDING;
    sl811_cs_config(link);
    break;

  case CS_EVENT_PM_SUSPEND:
    link->state |= DEV_SUSPEND;
    /* Fall through... */
  case CS_EVENT_RESET_PHYSICAL:
    if (link->state & DEV_CONFIG)
      pcmcia_release_configuration(link->handle);
    break;
  case CS_EVENT_PM_RESUME:
    link->state &= ~DEV_SUSPEND;
    /* Fall through... */
  case CS_EVENT_CARD_RESET:
    if (link->state & DEV_CONFIG)
      pcmcia_request_configuration(link->handle, &link->conf);

    INFO("FIXME: card reset\n");

    break;
  }
  return 0;
} /* sl811_cs_event */

/*====================================================================*/
static int __init init_sl811_cs(void)
{
#if LINUX_VERSION_CODE < KERNEL_VERSION(2,6,0)
  servinfo_t serv;
  DBG(0, "%s\n", version);
  CardServices(GetCardServicesInfo, &serv);
  if (serv.Revision != CS_RELEASE_CODE) {
    printk(KERN_NOTICE "sl811_cs: Card Services release "
	   "does not match!\n");
    return -EINVAL;
  }
  register_pccard_driver(&dev_info, &sl811_cs_attach, &sl811_cs_detach);
  return 0;
#else
  return pcmcia_register_driver(&sl811_driver);
#endif

}

/*====================================================================*/
static void __exit exit_sl811_cs(void)
{
#if LINUX_VERSION_CODE < KERNEL_VERSION(2,6,0) 
  DBG(0, "sl811_cs: unloading\n");
  unregister_pccard_driver(&dev_info);
  while (dev_list != NULL) {
    del_timer(&dev_list->release);
    if (dev_list->state & DEV_CONFIG)
      sl811_cs_release(dev_list);
    sl811_cs_detach(dev_list);
  }
#else
  pcmcia_unregister_driver(&sl811_driver);
#endif

}

/*====================================================================*/

module_init(init_sl811_cs);
module_exit(exit_sl811_cs);
