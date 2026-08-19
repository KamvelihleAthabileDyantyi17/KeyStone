using Microsoft.AspNetCore.Mvc;
using KeystoneApi.Models;

namespace KeystoneApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PropertiesController : ControllerBase
    {
        private static readonly List<Property> _properties = new()
        {
            new Property { Id = 1, Name = "Sunset Heights #4B", Address = "124 Beach Rd, Sea Point", Tenant = "John Doe", Status = "Occupied" },
            new Property { Id = 2, Name = "Greenwood Villa", Address = "45 Oak Ave, Rondebosch", Tenant = "Jane Smith", Status = "Occupied" },
            new Property { Id = 3, Name = "The Urban Loft #12", Address = "88 Long St, City Bowl", Tenant = "None", Status = "Vacant" },
            new Property { Id = 4, Name = "Harbour View Studio", Address = "120 Dock Rd, Foreshore", Tenant = "Mike Ross", Status = "Maintenance" }
        };

        [HttpGet]
        public ActionResult<IEnumerable<Property>> GetProperties()
        {
            return Ok(_properties);
        }

        [HttpPost]
        public ActionResult<Property> CreateProperty([FromBody] Property newProperty)
        {
            newProperty.Id = _properties.Max(p => p.Id) + 1;
            _properties.Add(newProperty);
            return CreatedAtAction(nameof(GetProperties), new { id = newProperty.Id }, newProperty);
        }
    }
}