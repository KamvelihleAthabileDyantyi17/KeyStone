var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddOpenApi();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

// In-memory property data for your Keystone app
var properties = new List<PropertyModel>
{
    new PropertyModel(1, "Sunset Heights #4B", "124 Beach Rd, Sea Point", "John Doe", "Occupied"),
    new PropertyModel(2, "Greenwood Villa", "45 Oak Ave, Rondebosch", "Jane Smith", "Occupied"),
    new PropertyModel(3, "The Urban Loft #12", "88 Long St, City Bowl", "None", "Vacant"),
    new PropertyModel(4, "Harbour View Studio", "120 Dock Rd, Foreshore", "Mike Ross", "Maintenance")
};

// Map the GET endpoint that your Android app will call
app.MapGet("/api/properties", () => properties)
   .WithName("GetProperties");

// Map a POST endpoint to add new properties later
app.MapPost("/api/properties", (PropertyModel newProperty) =>
{
    properties.Add(newProperty);
    return Results.Created($"/api/properties/{newProperty.Id}", newProperty);
});

app.Run();

// Data Model Record
record PropertyModel(int Id, string Name, string Address, string Tenant, string Status);