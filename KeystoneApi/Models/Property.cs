namespace KeystoneApi.Models
{
    public class Property
    {
        public int Id { get; set; }
        public string Name { get; set; } = string.Empty;
        public string Address { get; set; } = string.Empty;
        public string Tenant { get; set; } = string.Empty;
        public string Status { get; set; } = "Vacant";
    }
}